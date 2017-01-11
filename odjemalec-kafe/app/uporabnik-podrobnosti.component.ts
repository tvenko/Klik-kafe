import 'rxjs/add/operator/switchMap';
import { Component, OnInit }      from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location }               from '@angular/common';

import { Uporabnik }        from './uporabnik';
import { UporabnikService } from './uporabnik.service';

@Component({
  moduleId: module.id,
  selector: 'uporabnik-podrobnosti',
  templateUrl: 'uporabnik-podrobnosti.component.html'
})
export class UporabnikPodrobnostiComponent implements OnInit {
  uporabnik: Uporabnik;

  constructor(
    private uporabnikService: UporabnikService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.uporabnikService.getUporabnik(+params['id']))
      .subscribe(uporabnik => this.uporabnik = uporabnik);
  }

  nazaj(): void {
    this.location.back();
  }
}
