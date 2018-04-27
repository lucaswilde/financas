import {Input, Component} from '@angular/core';
import { CategoriaComponent } from '../categoria/categoria.component';

@Component({
    moduleId: module.id,
    selector: 'lancamento'
})
export class Lancamento {

    // propriedades que serao lidas pelo template
    // usando o decorator input indicamos q a propriedade pode receber valores
    @Input() valor: number;
    @Input() data: Date;
    @Input() obs: string;
    @Input() categoria: CategoriaComponent;
    @Input() tipo: string;
    @Input() parcelado: boolean;
    @Input() qtdParcelas: number;
    codLancamento: number;

    constructor() {

    }

}
