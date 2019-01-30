import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  blockStatus: any;
  status: any;
  message:any;
  constructor(private adminService: AdminService) { }

  ngOnInit() {
  }
  blockAnalyst(email) {
    this.adminService.blockAnalyst(email).subscribe(data => {
      this.status = data;
      this.blockStatus = this.status.blocked;
      this.message = this.status.message;
    });
  }
}
