package eak_04;

//package eak_04;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;



public class FXMLDocumentController implements Initializable {
    
private static final Logger logger = Logger.getLogger(eak_04_lab07.class);
    @FXML
    private Label a;
    @FXML
    private Label b;
    @FXML
    private Button buttonClear;
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonMath;
    @FXML
    private TextField textField_A;
    @FXML
    private TextField textField_B;
    @FXML
    private TextField textField_X;
    @FXML
    private Label x;
    @FXML
    private Label label_otvet;


    @FXML
    private void buttonMath(ActionEvent event) {
        double a, b, x, y;
        try {
            a = Double.parseDouble(textField_A.getText());
            b = Double.parseDouble(textField_B.getText());
            x = Double.parseDouble(textField_X.getText());
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textField_A.requestFocus();
            label_otvet.setText("В введенных значениях допущены ошибки");
            logger.error("В введённых значениях допущены ошибки");
            textField_A.setText("");
            textField_B.setText("");
            textField_X.setText("");
                logger.debug("Значения ячеек очищены");
            return;
        }
        if (3 <= x) {
            y = (x * ((a * a) + (b * b))) / (6 * a) ;
               logger.debug("Выполнено вычисление по алгоритму, где x <= 3");
        } else {
            y = x * (1 - (a * b));
            logger.debug("Выполнено вычисление по алгоритму, где x > 3");
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            label_otvet.setText("Ответ: " + String.format("%.2f", y));
        } else {
            label_otvet.setText("Нет ответа");
        }

    }
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonClear(ActionEvent event) {
        label_otvet.setText("Ответ: ");
        textField_A.setText("");
        textField_B.setText("");
        textField_X.setText("");
        logger.debug("Значения ячеек очищены");
    }

    @FXML
    private void buttonExit(ActionEvent event) {
        System.exit(0);
    }
}
