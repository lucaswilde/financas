export class MensagemCadastro {

    // por debaixo dos panos cria as propriedades `_memsagem` e `_inclusao` como privados
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