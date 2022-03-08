package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnCancella;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTempo;


    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	long startTime = System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	String ret = "";
    	for(String p : elenco.getElenco()) {
    		ret = ret + p + "\n";
    	}
    	ret = ret.substring(0, ret.length()-1);
    	txtResult.setText(ret);
    	txtParola.clear();
    	long fine = (System.nanoTime()- startTime);
    	txtTempo.setText(String.valueOf(fine));
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	long startTime = System.nanoTime();
    	txtResult.clear();
    	elenco.reset();
    	long fine = (System.nanoTime()- startTime);
    	txtTempo.setText(String.valueOf(fine));
    }
    
    @FXML
    void doCancel(ActionEvent event) {
    	//come cancellare anche l ultima parola dell elenco senza usare reset??
    	String parolaSelezionata = null;
    	boolean vuoto=false;
    	long startTime = System.nanoTime();
    	parolaSelezionata = txtResult.getSelectedText();
    	elenco.cancella(parolaSelezionata);
    	String ret = "";
    	for(String p : elenco.getElenco()) {
    		if(p!=null) {
    		ret = ret + p + "\n";}
    		else {
    			vuoto=true;
    		}
    	}if(vuoto==false) {
    	ret = ret.substring(0, ret.length()-1);}
    	else {ret= "Elenco vuoto";}
    	txtResult.setText(ret);
    	txtParola.clear();
    	long fine = (System.nanoTime() - startTime);
    	txtTempo.setText(String.valueOf(fine));

    }

    @FXML
    void initialize() {
    	assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
