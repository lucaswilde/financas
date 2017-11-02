import { RouterModule, Routes } from '@angular/router';
import { CategoriaListagemComponent } from './categoria/categoriaListagem.component';
import { CategoriaCadastroComponent } from './categoria/categoriaCadastro.component';
import { WelcomeComponent } from './welcome/welcome.component';

const appRoutes: Routes = [
    // http://localhost:4200/
    { path: '', component: WelcomeComponent }
    // http://localhost:4200/categoria
    , { path: 'categoria', component: CategoriaListagemComponent }
    , { path: 'cadastroCategoria', component: CategoriaCadastroComponent}

    //:id - curinga
    //{ path: 'cadastro/:id', component: CadastroComponent },
    // redireciona para o padrão caso não encontre o path, ex.: http://localhost:3000/abcde
    , { path: '**', redirectTo: ''}
];

// "compila" as rotas para o angular
// Sendo um módulo do ES2015, ele precisa exportar as rotas compiladas através do módulo RouterModule. 
export const routing = RouterModule.forRoot(appRoutes);