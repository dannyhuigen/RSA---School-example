package com.example.rsa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.Date;

public class RsaController {

    Stage currentStage;

    @FXML
    TextArea txtEncN; //Text-area encryption(left-side) N

    @FXML
    Label lblEncFindPAndQ; // Label encryption(left-side) Find P and Q solution

    @FXML
    Label lblEncNextE; // Label encryption(left-side) Next found E solution

    @FXML
    TextArea txtEncMsgToEncrypt; //Text-area encryption(left-side) message to encrypt

    @FXML
    TextArea txtEncEncryptedMsg; //Text-area encryption(left-side) the encrypted message result

    @FXML
    TextArea txtDecN; //Text-area decryption(right-side) the N value

    @FXML
    TextArea txtDecE; //Text-area decryption(right-side) the E value

    @FXML
    Label lblDecCalcD; // Label decryption(right-side) calculate D given N and E result

    @FXML
    TextArea txtDecEncryptedMsg; //Text-area decryption(right-side) the encrypted message to decrypt

    @FXML
    TextArea txtDecDecryptedMsg; //Text-area decryption(right-side) the decrypted message result

    int p = 0;

    int q = 0;

    public void setCurrentStage(Stage stage) {
        this.currentStage = stage;
    }

    @FXML
    protected void onEncFindPAndQClick() {
        if (!isValidIntInput(txtEncN)) return;
        int n = Integer.parseInt(txtEncN.getText());
        Date date = new Date();

        long startTime = date.getTime();
        this.p = RSAHelper.getPFromN(n);
        this.q = RSAHelper.getQFromPandN(n, p);

        if (!RSAHelper.isPrime(p) || !RSAHelper.isPrime(q) ) {
            txtEncN.setText("N IS NOT RELATIVELY PRIME");
            return;
        }

        date = new Date();
        long stopTime = date.getTime() - startTime;


        //TODO find P AND Q and set in global scope
        lblEncFindPAndQ.setText("P = " + this.p + "\nQ = new "+ this.q +" \nCalculation time = "+stopTime+"ms");
    }

    @FXML
    protected void onEncFindNextE() {
        //TODO get next E use P and Q

        int r = (p-1)*(q-1);

        lblEncNextE.setText("E = E \nCalculation time = 1000ms");
    }

    @FXML
    protected void onEncEncryptM() {
        String messageToEncrypt = txtEncMsgToEncrypt.getText();
        //TODO encrypt message
        txtEncEncryptedMsg.setText("The encrypted message");
    }

    @FXML
    protected void onDecCalculateD() {
        if (!isValidIntInput(txtDecN) || !isValidIntInput(txtDecE)) return;
        int n = Integer.parseInt(txtDecN.getText());
        int e = Integer.parseInt(txtDecE.getText());
        //TODO find D
        lblDecCalcD.setText("\n D = new D");
    }

    @FXML
    protected void onDecDecryptMessage() {
        String rawInput = txtDecEncryptedMsg.getText();
        //TODO decrypt input
        txtDecDecryptedMsg.setText("The decrypted message");
    }

    private boolean isValidIntInput(TextArea textArea) {
        try {
            Integer.parseInt(textArea.getText());
            return true;
        }
        catch (Exception e) {
            textArea.setText("WRONG INPUT PLEASE ONLY USE INTEGERS");
            return false;
        }
    }
}