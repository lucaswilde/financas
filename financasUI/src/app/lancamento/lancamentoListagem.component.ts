import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { LancamentoService } from './lancamento.service';
import { Lancamento } from './lancamento';

@Component({
    moduleId: module.id,
    selector: 'lancamentoListagem',
    templateUrl: './lancamentoListagem.component.html',
    providers: [LancamentoService]
})
export class LancamentoListagemComponent{

    lancamentoService: LancamentoService;
    listaLancamentos: Lancamento[] = [];

    constructor(lancamentoService: LancamentoService){
        this.lancamentoService = lancamentoService;

        this.listar();
    }

    remove(lancamento: Lancamento) {
        if(confirm('Excluir?')) {
            this.lancamentoService.remove(lancamento).subscribe(
                (sucesso) => {
                    this.listar()
                }, error => alert('Erro ao excluir ' + error)
            );
        }
    }

    listar() {
        this.lancamentoService.listar().subscribe(
            (listaLancamentos) => {
                console.log(listaLancamentos);
                this.listaLancamentos = listaLancamentos;
            },
            error => console.log(error)
        );
    }
}