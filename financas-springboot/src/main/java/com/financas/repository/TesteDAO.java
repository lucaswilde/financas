package com.financas.repository;

import java.util.List;

import com.financas.model.Categoria;

public class TesteDAO {

	public static void main(String[] args) {
		List<Categoria> lista = new CategoriaDAO().listar();
		for(Categoria categoria : lista) {
			System.out.println(categoria.getDescricao());
		}

	}

}
