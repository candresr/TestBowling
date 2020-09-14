import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { gameDTO } from '../../models/gameDTO';
import { TableScoredService } from '../../services/table-scored.service';
import { requestDTO } from '../../models/requestDTO';
import swal from 'sweetalert2';

@Component({
  selector: 'app-table-scored',
  templateUrl: './table-scored.component.html',
  styleUrls: ['./table-scored.component.css']
})
export class TableScoredComponent implements OnInit {

  @Input() game: gameDTO = new gameDTO();
  data: String[];
  post: requestDTO = new requestDTO();
  @ViewChild('scoredForm') scoredForm;

  constructor(
    public service: TableScoredService
  ) { }

  ngOnInit(): void {
  }

  calculate(){
    this.data = Object.values(this.game);
    console.log("data " + this.data);
    this.post.game = this.data;
    console.log("post " + Object.values(this.post));
    this.service.calculateScored(this.post).subscribe((response:any)=>{
      if(response.success)
      swal.fire("Su puntaje es:", " "+response.data , "success");
      this.clearForm();
    })
  }

  clearForm(){
    this.scoredForm.reset();
  }
}
