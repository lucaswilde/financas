import {Input, Component} from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'categoriaComponent'
})
export class CategoriaComponent{

    // propriedades que serao lidas pelo template
    // usando o decorator input indicamos q a propriedade pode receber valores
    @Input() desabilitado: boolean;
    @Input() descricao: string = '';
    codCategoria: number;

    constructor() {

    }

    get isDesabilitado(): boolean {
        if (this.desabilitado == null || this.desabilitado !== false){
            return false;
        }
        return true;
    }

}
