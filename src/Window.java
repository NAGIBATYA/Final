import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Window extends JFrame {

    private final int WIDTH = 800;
    private final int HEIGHT = 500;
    private JPanel panel;
    private JTextPane textpane;
    private JTextField number1;
    private JComboBox list;
    private Object type;
    private static String s;
    HttpResponse<String> response;

    public Window() {
        super();
        setTitle("Numbers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        getContentPane().add(panel);
        addWidgets();
        pack();
        setLocation(450, 5);
    }

    public void run() {
        setVisible(true);
    }

    private void addWidgets() {
        panel.setLayout(null);

        Font fontLBL = new Font("Calibri", Font.PLAIN, 25);
        Font fontBTN = new Font("Calibri", Font.PLAIN, 25);
        Font fontFact = new Font("Calibri",Font.PLAIN, 25);
        String fontfamily = panel.getFont().getFamily();

        Color color = new Color(0x1E7F94);
        Color color1 = new Color(0xFFCB00);
        Color color2 = new Color(0xFF99D2DA, true);
        Color color3 = new Color(0x2292AD);

        panel.setBackground(color);

        JLabel label = new JLabel("Введите число, дату или год, чтобы узнать о нём что-либо интересное.");
        label.setBounds(15, 20, 780, 100);
        label.setFont(fontLBL);
        label.setForeground(color1);
        panel.add(label);

        number1 = new JTextField();
        number1.setBackground(color2);
        number1.setFont(fontLBL);
        number1.setBounds(115, 130, 400,40);
        panel.add(number1);

        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(attribs, fontFact.getSize());
        StyleConstants.setFontFamily(attribs, fontfamily);
        StyleConstants.setForeground(attribs, color1);

        textpane = new JTextPane();
        textpane.setBounds(30, 200, 720, 180);
        textpane.setFont(fontFact);
        textpane.setBackground(color3);
        textpane.setEditable(false);
        textpane.setParagraphAttributes(attribs,true);
        panel.add(textpane);

        list = new JComboBox();
        list.addItem("Факт");
        list.addItem("Год");
        list.addItem("Дата");
        list.addItem("Математика");
        list.setFont(fontLBL);
        list.setBackground(color1);
        list.setBounds(520, 130, 160, 40);
        panel.add(list);

        JButton math = new JButton("Интересный факт");
        math.setBackground(color1);
        math.setFont(fontBTN);
        math.setBounds(150, 400, 500,60);
        panel.add(math);
        math.addActionListener(m -> {
            try {
                mechanism();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void trivia(){
        String number = number1.getText();
        type = list.getSelectedItem();
        HttpRequest request = null;
        String query = "http://numbersapi.com/" + number + "/trivia";
        try {
            request = HttpRequest.newBuilder().uri(new URI(query)).GET().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            s = translate(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textpane.setText(s);
    }

    private void year(){
        String number = number1.getText();
        type = list.getSelectedItem();
        HttpRequest request = null;
        String query = "http://numbersapi.com/" + number + "/year";
        try {
            request = HttpRequest.newBuilder().uri(new URI(query)).GET().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            s = translate(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textpane.setText(s);
    }

    private void date(){
        String number = number1.getText();
        type = list.getSelectedItem();
        HttpRequest request = null;
        String query = "http://numbersapi.com/" + number + "/date";
        try {
            request = HttpRequest.newBuilder().uri(new URI(query)).GET().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            s = translate(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textpane.setText(s);
    }

    private void math(){
        String number = number1.getText();
        type = list.getSelectedItem();
        HttpRequest request = null;
        String query = "http://numbersapi.com/" + number + "/math";
        try {
            request = HttpRequest.newBuilder().uri(new URI(query)).GET().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            s = translate(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textpane.setText(s);
    }

    private void mechanism() throws InterruptedException {
        String number = number1.getText();
        type = list.getSelectedItem();
        HttpRequest request = null;
        if (type.equals("Факт")){
            trivia();
        }else if (type.equals("Год")){
            year();
        }else if (type.equals("Дата")){
            date();
        }else if (type.equals("Математика")){
            math();
        }
    }

    public static String translate(String word) throws IOException, InterruptedException {
        Thread.sleep(1500);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://microsoft-translator-text.p.rapidapi.com/translate?to%5B0%5D=ru&api-version=3.0&profanityAction=NoAction&textType=plain"))
                .header("content-type", "application/json")
                .header("X-RapidAPI-Host", "microsoft-translator-text.p.rapidapi.com")
                .header("X-RapidAPI-Key", "0e0345dbc8msh8a0de13a6e012d1p1c4379jsn3e8c02db7303")
                .method("POST", HttpRequest.BodyPublishers.ofString("[{\"Text\": \""+word+"\"}]"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray arr = new JSONArray(response.body());
        JSONObject obj = (JSONObject) arr.get(0);
        arr = (JSONArray) obj.get("translations");
        obj = (JSONObject) arr.get(0);
        return (String) obj.get("text");
    }
}