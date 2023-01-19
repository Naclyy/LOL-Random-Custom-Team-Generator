import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Teams } from '../modules/teams';
import { PlayerService } from '../services/player.service';

@Component({
  selector: 'app-generate-teams',
  templateUrl: './generate-teams.component.html',
  styleUrls: ['./generate-teams.component.css']
})
export class GenerateTeamsComponent {
  
  public teams:Teams[] = []

  constructor(private router: Router, private playerService: PlayerService) {
  }


  ngOnInit(): void {
    this.getAllUsers();
    console.log(this.teams)
  }
  public getAllUsers(): void{
    this.playerService.getTeams().subscribe((response: Teams[]) => {
      this.teams = response
      console.log(response)
    }),(error: HttpErrorResponse) => {
      alert(error.message);
    };
  }
}
