package controle;

import java.util.List;

import classes.Categoria;

public class TesteDAO {

	public static void main(String[] args) {
		List<Categoria> lista = new CategoriaDAO().listar();
		for(Categoria categoria : lista) {
			System.out.println(categoria.getDescricao());
		}

	}

}
