import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { CategoriaComponent } from './categoria.component';

@Injectable() // necessario para o construtor conseguir injetar o Http
export class CategoriaService{

    http: Http;
    headers: Headers;
    url: string = 'http://localhost:8080/financas/listAllCategorias';

    constructor(http: Http){
        this.headers = new Headers();
        this.http = http;
        this.headers.append('Content-Type', 'application/json');
    }

    listar():Observable<CategoriaComponent[]>{
        return this.http.get(this.url)
            .map(res => res.json().result);
    }

    cadastra(foto: CategoriaComponent): Observable<MensagemCadastro> {
        if(foto._id){
            // atualiza
            return this.http.put(this.url + "/" + foto._id, JSON.stringify(foto), {headers: this.headers})
            .map(() => new MensagemCadastro('Foto alterada com sucesso', false));
        } else{
            // insere
            return this.http.post(this.url, JSON.stringify(foto), {headers: this.headers})
            .map(() => new MensagemCadastro('Foto incluída com sucesso', true));
        }
    }

    remove(foto: CategoriaComponent): Observable<Response>{
        return this.http.delete(this.url + "/" + foto._id, {headers: this.headers});
    }

    buscarPorId(id:string): Observable<CategoriaComponent>{
        return this.http.get(this.url + "/" + id).map(res => res.json());
    }
}

export class MensagemCadastro{

    // por debaixo dos panos cria das propriedades `_memsagem` e `_inclusao` como privados
    constructor(private _mensagem: string, private _inclusao: boolean) {
        this._mensagem = _mensagem;
        this._inclusao = _inclusao;
    }

    public get mensagem(): string {
        return this._mensagem;
    }

    public get inclusao(): boolean {
        return this._inclusao;
    }
}