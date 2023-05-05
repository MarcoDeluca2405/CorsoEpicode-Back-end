package Epicode.mainProject.eb;

public abstract class Multimediale {

		private String titolo;
		private int durata;
		

		public  void play() {
			
			if(durata>0) {
				
				for(int i=0;i<durata;i++) {
					
					System.out.println(this.titolo);
					
				}
				
			}else {
				
				System.out.println("è un immagine");
				
			}
			
		}
		
		public String getTitolo() {
			return titolo;
		}

		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}

		public int getDurata() {
			return durata;
		}

		public void setDurata(int durata) {
			this.durata = durata;
		}
		
		
		@Override
		public  String toString() {
			return this.titolo+" "+this.durata;
		}
	
}
