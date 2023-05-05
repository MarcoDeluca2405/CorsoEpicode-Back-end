package Epicode.mainProject.eb;

public class RegistrazioneAudio extends Multimediale implements Volume {
	
	private int vol=8;
	private String [] vol_attuale= new String [10];
	
	
	public RegistrazioneAudio(String titolo,int durata) {
		super.setTitolo(titolo);
		super.setDurata(durata);
	}
	
	
	@Override
	public void play() {
		super.play();
		getVolumeAttuale();
	}
	
	public void volAttuale() {
		
		for(int i=0;i<this.vol;i++) {
			
			this.vol_attuale[i]="!";
			
		}
		
			
	}
	
	
	
	public void getVolumeAttuale() {
		volAttuale();
		
for(int i=0;i<this.vol_attuale.length;i++) {
			if(this.vol_attuale[i]==null) {
				System.out.print(" ("+i+")");
				System.out.println("");
				break;
			}else {
				System.out.print(this.vol_attuale[i]);
				
			}
		}
		
		
	}
	
	
	
	@Override
	public void abbassaVolume() {
		if(this.vol>0) {		
		this.vol=this.vol-1;
		this.vol_attuale[vol]=null;
		for(int i=0;i<this.vol;i++) {
			System.out.println(i);
			if(vol_attuale[i]!=null) {
				
			this.vol_attuale[i]="!";
			}else {
				break;
			}
			
		}
		
		}
		
		getVolumeAttuale();
	}

	@Override
	public void alzaVolume() {
		if(this.vol<9) {
		this.vol=this.vol+1;
		for(int i=0;i<this.vol;i++) {
				
				this.vol_attuale[i]="!";
				
			
		
		}
		}else {
			return;
	}
		getVolumeAttuale();
}

}