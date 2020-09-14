import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TableScoredComponent } from './components/table-scored/table-scored.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/table-scored',
    pathMatch: 'full'
  },
  {
    path: 'table-scored',
    component: TableScoredComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
