package Epicode.mainProject.eb;

class Video extends RegistrazioneAudio implements Luminosità{
	private int lum=3;
	private String [] lum_attuale= new String [10];
	
	
	public Video(String titolo, int durata) {
		super(titolo, durata);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void play() {
		super.play();
		this.getLuminositaAttuale();
	}
	
	

	public int getLum() {
		return lum;
	}


	public void setLum(int lum) {
		this.lum = lum;
	}


	public String [] getLum_attuale() {
		
		return lum_attuale;
	}


	public void setLum_attuale(String [] lum_attuale) {
		this.lum_attuale = lum_attuale;
	}



	
	public void lumAttuale() {
		
		for(int i=0;i<this.lum;i++) {
			
			this.lum_attuale[i]="*";
			
		}
		
			
	}
	
	
	
	public void getLuminositaAttuale() {
		lumAttuale();
		
for(int i=0;i<this.lum_attuale.length;i++) {
			if(this.lum_attuale[i]==null) {
				System.out.print(" ("+i+")");
				System.out.println("");
				break;
			}else {
				System.out.print(this.lum_attuale[i]);
				
			}
		}
		
		
	}
	


	@Override
	public void aumentaLuminosita() {
		
		if(this.lum<9) {
			this.lum=this.lum+1;
			for(int i=0;i<this.lum;i++) {
					
					this.lum_attuale[i]="*";
					
				
			
			}
		}else {
			return;
		}
			getLuminositaAttuale();
		
		
	}





	@Override
	public void diminuisciLuminosita() {
		
		if(this.lum>0) {		
			this.lum=this.lum-1;
			this.lum_attuale[lum]=null;
			for(int i=0;i<this.lum;i++) {
				System.out.println(i);
				if(lum_attuale[i]!=null) {
					
				this.lum_attuale[i]="!";
				}else {
					break;
				}
				
			}
			
			}
			
			getLuminositaAttuale();
		
	}
	
	
}
