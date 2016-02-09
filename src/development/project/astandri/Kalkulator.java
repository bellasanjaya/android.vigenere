package development.project.astandri;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Kalkulator extends Activity implements OnClickListener {
/** Called when the activity is first created. */
	EditText I1, I2, I3;
	Button RTambah, RKurang;
	TextView jumlah;
	
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		String dataHuruf = "abcdefghijklmnopqrstuvwxyz";
		
		I1 = (EditText)findViewById(R.id.I1);
		I2 = (EditText)findViewById(R.id.I2);
		String chiper = "";
		
		

		jumlah = (TextView) findViewById(R.id.hasil);
		
		RTambah = (Button)findViewById(R.id.RTambah);
		RKurang = (Button)findViewById(R.id.RKurang);

		
		RTambah.setOnClickListener(this);
		RKurang.setOnClickListener(this);

	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
			case R.id.RTambah:
				String dataHuruf = "abcdefghijklmnopqrstuvwxyz";
				String chiper = "";
				
				String pesan = I1.getText().toString();
				String kunci = I2.getText().toString();
				
		        ArrayList<Integer> en = new ArrayList<Integer>();


		        
		        Scanner s = new Scanner();
		        ArrayList<Integer> sP = s.scannPesan(pesan, dataHuruf);
		        ArrayList<Integer> sK = s.scannKuci(pesan, kunci, dataHuruf);
				
				
		        
		        
		        
		        EnkripDekrip ed = new EnkripDekrip();
		        for (int i = 0; i < pesan.length(); i++) {
		            int iP = Integer.parseInt(sP.get(i).toString());
		            int iK = Integer.parseInt(sK.get(i).toString());
		            int gE = ed.getEnkrip(iP, iK, dataHuruf);
		            en.add(gE);

		        }
		        String hEN = ed.getHasil(en, dataHuruf);
		        chiper = hEN;
		        
		        
		        
		        
		        
				jumlah.setText(hEN);
				
							
				
				
				
				
				
				
				
				
				
				
				break;
			case R.id.RKurang:
				String dataHuruf1 = "abcdefghijklmnopqrstuvwxyz";
				String pesan1 = I1.getText().toString();
				String kunci1 = I2.getText().toString();
				
		        ArrayList<Integer> de = new ArrayList<Integer>();
				
				 Scanner s2 = new Scanner();
			        ArrayList<Integer> sC = s2.scannPesan(pesan1, dataHuruf1);
			        ArrayList<Integer> sK2 = s2.scannKuci(pesan1, kunci1, dataHuruf1);
			        
			        System.out.println("\nDekripsi");
			        EnkripDekrip ed2 = new EnkripDekrip();
			        for (int i = 0; i < pesan1.length(); i++) {
			            int iC = Integer.parseInt(sC.get(i).toString());
			            int iK2 = Integer.parseInt(sK2.get(i).toString());
			            int gDE = ed2.getDekrip(iC, iK2, dataHuruf1);
			            
			            de.add(gDE);
			        }
			        
			        String hDE = ed2.getHasil(de, dataHuruf1);
			       
			        jumlah.setText(hDE);
				
				
				
				
				
				
				
				
				
				break;

			default:
				break;
		}
	}
}