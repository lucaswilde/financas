import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Lancamento } from './lancamento';
import { MensagemCadastro } from './../util/mensagem.cadastro';
import { Constantes } from '../util/constantes';
import { LancamentoQueryRequest } from './lancamento.query.request';

@Injectable() // necessario para o construtor conseguir injetar o Http
export class LancamentoService {

    http: Http;
    headers: Headers;
    url = Constantes.BACKEND_URL + '/v1/lancamentos';

    constructor(http: Http) {
        this.headers = new Headers();
        this.http = http;
        this.headers.append('Content-Type', 'application/json');
        //this.headers.append('Access-Control-Allow-Origin', '*');
    }

    listar(lancamentoQueryRequest: LancamentoQueryRequest): Observable<Lancamento[]> {
        /* node js
        return this.http.get(this.url)
            .map(res => res.json().result);
            */
        const listarUrl = this.url + '/findAllBy?lancamentoRequest=' + encodeURIComponent(JSON.stringify(lancamentoQueryRequest));
        console.log('listarUrl = ' + listarUrl);
        return this.http.get(listarUrl)
            .map(res => res.json());
    }

    cadastra(lancamento: Lancamento): Observable<MensagemCadastro> {
        const saveUrl = this.url + '/save';
        return this.http.post(saveUrl, JSON.stringify(lancamento), { headers: this.headers })
            .map(() => new MensagemCadastro('Lançamento incluída com sucesso', true));
    }

    remove(lancamento: Lancamento): Observable<Response> {
        return this.http.delete(this.url + '/' + lancamento.codLancamento, { headers: this.headers });
    }

    buscarPorId(id: string): Observable<Lancamento> {
        return this.http.get(this.url + '/' + id).map(res => res.json());
    }
}
