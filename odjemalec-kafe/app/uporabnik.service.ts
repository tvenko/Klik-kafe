import {Injectable}    from '@angular/core';
import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {Uporabnik} from './uporabnik';

@Injectable()
export class UporabnikService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private url = 'http://localhost:8081/prpo-vaje-rest/v1/uporabniki';

  constructor(private http: Http) {
  }

  getUporabniki(): Promise<Uporabnik[]> {
    return this.http.get(this.url)
      .toPromise()
      .then(response => response.json() as Uporabnik[])
      .catch(this.handleError);
  }

  getUporabnik(id: number): Promise<Uporabnik> {
    const url = `${this.url}/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Uporabnik)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.url}/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  create(uporabnik: Uporabnik): Promise<void> {
    return this.http
      .post(this.url, JSON.stringify(uporabnik), {headers: this.headers})
      .toPromise()
      .then()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Prišlo je do napake', error);
    return Promise.reject(error.message || error);
  }
}

