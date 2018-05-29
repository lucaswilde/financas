import { Input, Component } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'lancamentoQueryRequest'
})
export class LancamentoQueryRequest {
    @Input() year: number;
    @Input() month: number;
    @Input() date: Date;

    constructor() {

    }

}