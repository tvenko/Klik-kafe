import {Component, OnInit} from '@angular/core';
import {Router}            from '@angular/router';

import {Uporabnik}                from './uporabnik';
import {UporabnikService}         from './uporabnik.service';

@Component({
  moduleId: module.id,
  selector: 'dodaj-uporabniki',
  templateUrl: 'uporabniki-dodaj.component.html'
})
export class UporabnikiDodajComponent {
  uporabnik: Uporabnik = new Uporabnik;

  constructor(private uporabnikService: UporabnikService,
              private router: Router) {
  }

  submitForm(): void {
    this.uporabnikService
      .create(this.uporabnik)
      .then(() => {
        this.router.navigate(['/uporabniki']);
      });
  }

  nazaj(): void {
    this.router.navigate(['/uporabniki']);
  }

}
