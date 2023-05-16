package model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clienti")
public class Cliente {


		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name= "numero_cliente")
		private Integer numeroCliente;
		
		@Column(nullable = false)
		private String nome;
		
		@Column(nullable = false)
		private String cognome;
		
		@Column(name="data_nascita")
		private LocalDate dataNascita;
		
		@Column(unique=true,nullable = false)
		private String email;
		
		@Column(name="regione_residenza")
		private String regioneRresidenza;

		/**
		 * @return the numeroCliente
		 */
		public Integer getNumeroCliente() {
			return numeroCliente;
		}

		/**
		 * @param numeroCliente the numeroCliente to set
		 */
		public void setNumeroCliente(Integer numeroCliente) {
			this.numeroCliente = numeroCliente;
		}

		/**
		 * @return the nome
		 */
		public String getNome() {
			return nome;
		}

		/**
		 * @param nome the nome to set
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}

		/**
		 * @return the cognome
		 */
		public String getCognome() {
			return cognome;
		}

		/**
		 * @param cognome the cognome to set
		 */
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		/**
		 * @return the dataNascita
		 */
		public LocalDate getDataNascita() {
			return dataNascita;
		}

		/**
		 * @param dataNascita the dataNascita to set
		 */
		public void setDataNascita(LocalDate dataNascita) {
			this.dataNascita = dataNascita;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the regioneRresidenza
		 */
		public String getRegioneRresidenza() {
			return regioneRresidenza;
		}

		/**
		 * @param regioneRresidenza the regioneRresidenza to set
		 */
		public void setRegioneRresidenza(String regioneRresidenza) {
			this.regioneRresidenza = regioneRresidenza;
		}

		@Override
		public String toString() {
			return "Cliente [numeroCliente=" + numeroCliente + ", nome=" + nome + ", cognome=" + cognome
					+ ", dataNascita=" + dataNascita + ", email=" + email + ", regioneRresidenza=" + regioneRresidenza
					+ "]";
		}
		
		
		
}	