import './rxjs-extensions';

import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule}    from '@angular/http';
import {FormsModule}   from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';

import {AppComponent}         from './app.component';
import {UporabnikiComponent}      from './uporabniki.component';
import {UporabnikiDodajComponent}      from './uporabniki-dodaj.component';
import {UporabnikPodrobnostiComponent}  from './uporabnik-podrobnosti.component';
import {UporabnikService}          from './uporabnik.service';


@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule,
    FormsModule
  ],
  declarations: [
    AppComponent,
    UporabnikiComponent,
    UporabnikPodrobnostiComponent,
    UporabnikiDodajComponent
  ],
  providers: [UporabnikService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

