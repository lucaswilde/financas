import { Component, Input } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CategoriaComponent } from './categoria.component';
import { CategoriaService } from './categoria.service';

@Component({
    moduleId: module.id
    , selector: 'categoriaCadastro'
    , templateUrl: './categoriaCadastro.component.html'
    , providers: [CategoriaService, FormBuilder]
})
export class CategoriaCadastroComponent {
    categoria: CategoriaComponent = new CategoriaComponent();
    http: Http;
    meuForm: FormGroup;
    service: CategoriaService;
    route: ActivatedRoute;
    router: Router;
    mensagem: string = '';

    constructor(service: CategoriaService, fb: FormBuilder, route: ActivatedRoute, router: Router){
        this.service = service;
        this.route = route;
        this.router = router;

        this.route.params.subscribe(params => {
                let id = params['id'];
                console.log('id: ' + id);
                if(id){
                    this.service.buscarPorId(id).subscribe(
                        categoria => this.categoria = categoria,
                        erro => console.log(erro)
                    );
                }
            }
        );

        this.meuForm = fb.group({
            descricao: ['', Validators.required]
        });
    }

    cadastrar(event: Event){
        // previne o compormento default do javascript que é submeter o formulario, isso evitará que a página seja recarregada
        event.preventDefault();
        console.log('Categoria a ser salva: ' + JSON.stringify(this.categoria));

        this.service.cadastra(this.categoria).subscribe(res => {
            this.categoria = new CategoriaComponent();
            this.mensagem = res.mensagem;
            console.log('Categoria salva com sucesso');
            if(!res.inclusao){
                this.router.navigate(['']);
            }
        }, erro => {
            console.log(erro);
        });
    }
 }