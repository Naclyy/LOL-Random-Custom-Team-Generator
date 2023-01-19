import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Summoner } from '../modules/summoner';
import { PlayerService } from '../services/player.service';
@Component({
  selector: 'app-add-players',
  templateUrl: './add-players.component.html',
  styleUrls: ['./add-players.component.css']
})
export class AddPlayersComponent {
  public smurf: boolean = false;
  public players: Summoner[] = [];
  public curentPlayer: Summoner | undefined;
  public isButtonVisible = false;

  constructor(private router: Router, private playerService: PlayerService) {
  }

  public addPlayer(addForm: NgForm): void {
    if (this.players.length < 10)
      this.players.push({ userName: addForm.value.username, smurf: this.smurf } as Summoner)
  }
  public checkboxClicked(): void {
    this.smurf = !this.smurf
  }

  public generateTeams(): void {
    this.playerService.sendPlayers(this.players);
    this.router.navigate(["generate"]);
  }

  public delete(index : any) : void{
    console.log(index);
    this.players.splice(index, 1);
  }
}
