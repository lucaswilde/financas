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
}