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
export class LancamentoListagemComponent {

    lancamentoService: LancamentoService;
    listaLancamentos: Lancamento[] = [];
    mesSelectedValue: number;
    meses = [
        { value: 0, viewValue: 'Nenhum' }
        , {value: 1, viewValue: '1 - Janeiro'}
        , { value: 2, viewValue: '2 - Fevereiro' }
        , { value: 3, viewValue: '3 - Março' }
        , { value: 4, viewValue: '4 - Abril' }
        , { value: 5, viewValue: '5 - Maio' }
        , { value: 6, viewValue: '6 - Junho' }
        , { value: 7, viewValue: '7 - Julho' }
        , { value: 8, viewValue: '8 - Agosto' }
        , { value: 9, viewValue: '9 - Setembro' }
        , { value: 10, viewValue: '10 - Outubro' }
        , { value: 11, viewValue: '11 - Novembro' }
        , { value: 12, viewValue: '12 - Dezembro' }
    ];

    constructor(lancamentoService: LancamentoService){
        this.lancamentoService = lancamentoService;
        this.mesSelectedValue = 2;
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