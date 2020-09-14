import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { TableScoredComponent } from './components/table-scored/table-scored.component';
import { FormsModule } from '@angular/forms';
import { TableScoredService } from './services/table-scored.service';


@NgModule({
  declarations: [
    AppComponent,
    TableScoredComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TableScoredService],
  bootstrap: [AppComponent]
})
export class AppModule { }
