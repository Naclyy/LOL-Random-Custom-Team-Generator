import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Summoner } from '../modules/summoner';
import { Teams } from '../modules/teams';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  private apiServerUrl = 'http://localhost:8080';
  private status : any;
  private errorMessage: any;
  constructor(private http: HttpClient) { }

  public sendPlayers(players : Summoner[]): void{
    console.log(`${this.apiServerUrl}/api/players`)
    const headers = { "Access-Control-Allow-Origin": "*" };
    this.http.post<void>(`${this.apiServerUrl}/api/players`, players).subscribe({
      next: data => {
          this.status = 'Send successful';
      },
      error: error => {
          this.errorMessage = error.message;
          console.error('There was an error!', error);
      }
  });
  }

  public getTeams(): Observable<Teams[]>{
    console.log(`${this.apiServerUrl}/api/teams`)
    const headers = { "Access-Control-Allow-Origin": "*" };
    return this.http.get<Teams[]>(`${this.apiServerUrl}/api/teams`)
  }
}
