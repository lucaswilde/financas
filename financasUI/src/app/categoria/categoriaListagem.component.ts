import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { CategoriaService } from './categoria.service';
import { CategoriaComponent } from './categoria.component';

@Component({
    moduleId: module.id,
    selector: 'categoriaListagem',
    templateUrl: './categoriaListagem.component.html',
    providers: [CategoriaService]
})
export class CategoriaListagemComponent{

    categoriaService: CategoriaService;
    listaCategorias: CategoriaComponent[] = [];

    constructor(categoriaService: CategoriaService){
        this.categoriaService = categoriaService;

        this.listar();
    }

    remove(categoria: CategoriaComponent) {
        if(confirm('Excluir?')) {
            this.categoriaService.remove(categoria).subscribe(
                (sucesso) => {
                    this.listar()
                }, error => alert('Erro ao excluir ' + error)
            );
        }
    }

    listar() {
        this.categoriaService.listar().subscribe(
            (listaCategorias) => {
                console.log(listaCategorias);
                this.listaCategorias = listaCategorias;
            },
            error => console.log(error)
        );
    }
}