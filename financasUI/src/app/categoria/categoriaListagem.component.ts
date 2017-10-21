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
    //categoria: CategoriaComponent;
    listaCategorias: CategoriaComponent[] = [];

    constructor(categoriaService: CategoriaService){
        this.categoriaService = categoriaService;

        this.categoriaService.listar().subscribe(
            (listaCategorias) => {
                this.listaCategorias = listaCategorias;
                console.log(listaCategorias);
            },
            error => console.log(error)
        );
    }
}