package projeto.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import projeto.models.Curriculo;
import projeto.models.ExpDocente;
import projeto.models.ExpRelevante;
import projeto.models.Publicacao;
import projeto.models.Titulo;

/**
 * @author Arthur, Gustavo, Rodolfo, C.Marcelo
 *
 */
public class CurriculoController {

	private static LinkedList<Curriculo> curriculos = null;
	
	public CurriculoController()
	{
		if(curriculos==null)
			curriculos = new LinkedList<Curriculo>();
	}
	
	public boolean add(Curriculo obj) {
		System.out.println("adicionado");
		return curriculos.add(obj);
	}

	/**
	 * @param curriculo
	 * @return
	 */
	public boolean uptade(Curriculo curriculo)
	{
		for(Curriculo c:curriculos)
		{
			if(c.getId()==curriculo.getId())
			{
				c.setNome(curriculo.getNome());
				c.setCpf(curriculo.getCpf());
				c.setEmail(curriculo.getEmail());
				c.setEndereco(curriculo.getEndereco());
				c.setReg_profissional(curriculo.getReg_profissional());
				c.setTelefone(curriculo.getTelefone());
				c.setTitulos(curriculo.getTitulos());
				System.out.println("atualizado");
				return true;
			}
		}
		return false;
	}
	
	public Curriculo get(int i) {
		if(i>curriculos.size())
			return null;
		return curriculos.get(i);
	}

	public Curriculo find(String nome)
	{
		for(Curriculo curriculo : curriculos)
		{
			if(curriculo.getNome().equals(nome))
				return curriculo;
		}
		return null;
	}
	
	public int getSize()
	{
		return curriculos.size();
	}
	
	public boolean save() {
		boolean erro=false;
		try {
			DataOutputStream output =  new DataOutputStream(new FileOutputStream("curriculos.dat", false));
			DataOutputStream outputTitulos = new DataOutputStream(new FileOutputStream("titulos.dat", false));
			DataOutputStream outputExpDoc = new DataOutputStream(new FileOutputStream("expDocente.dat", false));
			DataOutputStream outputExpRel = new DataOutputStream(new FileOutputStream("expRelevante.dat", false));
			DataOutputStream outputPub = new DataOutputStream(new FileOutputStream("publicacoes.dat", false));
			for(Curriculo curriculo : curriculos)
			{
				output.writeInt(curriculo.getId());
				output.writeUTF(curriculo.getNome());
				output.writeUTF(curriculo.getEndereco());
				output.writeUTF(curriculo.getTelefone());
				output.writeUTF(curriculo.getEmail());
				output.writeUTF(curriculo.getCpf());
				output.writeInt(curriculo.getReg_profissional());
				//gravação de titulos
				for(Titulo ti : curriculo.getTitulos())
				{
					outputTitulos.writeInt(curriculo.getId());
					outputTitulos.writeInt(ti.getAno());
					outputTitulos.writeUTF(ti.getFormacao());
					outputTitulos.writeUTF(ti.getCurso());
					outputTitulos.writeUTF(ti.getInstituicao());
					outputTitulos.writeUTF(ti.getCidade());
					outputTitulos.writeUTF(ti.getEstado());
				}
				//gravação de ExpDocente
				for(ExpDocente exp : curriculo.getExpsDocente())
				{
					outputExpDoc.writeInt(curriculo.getId());
					outputExpDoc.writeInt(exp.getData_inicio());
					outputExpDoc.writeInt(exp.getData_fim());
					outputExpDoc.writeUTF(exp.getDescricao());
					outputExpDoc.writeUTF(exp.getInstituicao());
					outputExpDoc.writeUTF(exp.getCidade());
					outputExpDoc.writeUTF(exp.getEstado());
				}
				//gravação de ExpRelevante
				for(ExpRelevante exp : curriculo.getExpsRelevante())
				{
					outputExpRel.writeInt(curriculo.getId());
					outputExpRel.writeInt(exp.getData_inicio());
					outputExpRel.writeInt(exp.getData_fim());
					outputExpRel.writeUTF(exp.getDescricao());
					outputExpRel.writeUTF(exp.getInstituicao());
					outputExpRel.writeUTF(exp.getCidade());
					outputExpRel.writeUTF(exp.getEstado());
				}
				//gravação de publicações
				for(Publicacao pub : curriculo.getPublicacoes())
				{
					outputPub.writeInt(curriculo.getId());
					outputPub.writeUTF(pub.getTitulo());
					outputPub.writeUTF(pub.getAutores());
					outputPub.writeUTF(pub.getEvento());
					outputPub.writeInt(pub.getAno());
					outputPub.writeUTF(pub.getArea());
				}
			}
			outputTitulos.flush();
			outputTitulos.close();
			//
			outputExpDoc.flush();
			outputExpDoc.close();
			//
			outputExpRel.flush();
			outputExpRel.close();
			//
			outputPub.flush();
			outputPub.close();
			//
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			erro=true;
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (IOException e) {
			erro=true;
			JOptionPane.showMessageDialog(null, "Arquivo ao gravar arquivo!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			erro=false;
		}
		if(!erro)
			return true;
		else
			return false;
	}

	public boolean load() {
		curriculos.clear();
		readCurriculos();
		readTitulos();
		readExpDocente();
		readExpRelevante();
		readPublicacoes();
		return true;
	}
	
	private void readCurriculos()
	{
		boolean moreRecords=true;
		try {
			DataInputStream input = new DataInputStream(new FileInputStream("curriculos.dat"));
			while(moreRecords)
			{
				Curriculo cur = new Curriculo(input.readInt(), input.readUTF(), input.readUTF(), input.readUTF(), input.readUTF(), input.readUTF(), input.readInt());
				curriculos.add(cur);
			}
			input.close();
			System.out.println("Ok");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}catch (EOFException e) {
			moreRecords=false;
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Arquivo ao ler arquivo!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void readTitulos()
	{
		boolean moreRecords=true;
		try {
			DataInputStream input = new DataInputStream(new FileInputStream("titulos.dat"));
			while(moreRecords)
			{
				int id = input.readInt();
				Titulo ti = new Titulo(input.readInt(), input.readUTF(), input.readUTF(), input.readUTF(), input.readUTF(), input.readUTF());
				for(Curriculo cur : curriculos)
				{
					if(cur.getId()==id)
						cur.getTitulos().add(ti);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}catch (EOFException e) {
			moreRecords=false;
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Arquivo ao ler arquivo!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void readExpDocente()
	{
		boolean moreRecords=true;
		try {
			DataInputStream input = new DataInputStream(new FileInputStream("expDocente.dat"));
			while(moreRecords)
			{
				int id = input.readInt();
				ExpDocente exp = new ExpDocente(input.readInt(), input.readInt(), input.readUTF(), input.readUTF(), input.readUTF(), input.readUTF());
				for(Curriculo cur : curriculos)
				{
					if(cur.getId()==id)
						cur.getExpsDocente().add(exp);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}catch (EOFException e) {
			moreRecords=false;
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Arquivo ao ler arquivo!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void readExpRelevante()
	{
		boolean moreRecords=true;
		try {
			DataInputStream input = new DataInputStream(new FileInputStream("expRelevante.dat"));
			while(moreRecords)
			{
				int id = input.readInt();
				ExpRelevante exp = new ExpRelevante(input.readInt(), input.readInt(), input.readUTF(), input.readUTF(), input.readUTF(), input.readUTF());
				for(Curriculo cur : curriculos)
				{
					if(cur.getId()==id)
						cur.getExpsRelevante().add(exp);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}catch (EOFException e) {
			moreRecords=false;
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Arquivo ao ler arquivo!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void readPublicacoes()
	{
		boolean moreRecords=true;
		try {
			DataInputStream input = new DataInputStream(new FileInputStream("publicacoes.dat"));
			while(moreRecords)
			{
				int id = input.readInt();
				Publicacao pub = new Publicacao(input.readUTF(), input.readUTF(), input.readUTF(), input.readUTF(), input.readInt());
				for(Curriculo cur : curriculos)
				{
					if(cur.getId()==id)
						cur.getPublicacoes().add(pub);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}catch (EOFException e) {
			moreRecords=false;
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "Arquivo ao ler arquivo!\n"+e.getCause(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
