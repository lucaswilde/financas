import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpModule } from '@angular/http';
import 'rxjs/add/operator/map'; // usa do NgModule
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { routing } from './app.routes';
import { CategoriaListagemComponent } from './categoria/categoriaListagem.component';
import { CategoriaCadastroComponent } from './categoria/categoriaCadastro.component';
import { LancamentoListagemComponent } from './lancamento/lancamentoListagem.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { BotaoModule } from './botao/botao.module';

@NgModule({
  // Todos os componentes que fizerem parte do módulo, precisam ser registrados em declarations. 
  // quando o módulo da aplicação for carregado, precisamos indicar qual será o primeiro componente carregado, 
  // nesse caso queremos que seja o AppComponent tanto para o declaration quanto o bootstrap
  declarations: [
    AppComponent, CategoriaListagemComponent, CategoriaCadastroComponent, WelcomeComponent, LancamentoListagemComponent
  ],
  /*Veja que nossa classe AppModule possui o decorator NgModule e que neste decorator importarmos o BrowserModule, 
    através da propriedade imports. Isso indica que um módulo anotado com ngModule pode importar outros módulos também anotados com ngModule. 
    No caso, BrowserModule, ao ser carregado, já disponibiliza diversos recursos padrões do Angular sem termos que importar cada recurso 
    individualmente como as diretivas ngIf e ngFor
    */
  imports: [
    BrowserModule
    , HttpModule
    , routing
    , FormsModule
    , ReactiveFormsModule
    , BotaoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
