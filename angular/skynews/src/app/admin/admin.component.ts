import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  blockStatus: any;
  status: any;
  message: any;
  email = new FormControl();
  userData: any;
  invalidEmail: boolean;
  constructor(private adminService: AdminService) { }

  ngOnInit() {
  }
  searchByEmailId() {
    this.adminService.findByEmailId(this.email.value).subscribe(data => {
      if (data) {
        this.userData = data;
      } else {
        this.invalidEmail = true;
      }


    });
  }
  blockAnalyst() {
    this.adminService.blockAnalyst(this.userData).subscribe(status => {
      this.status = status;
      this.blockStatus = this.status.blocked;
      this.message = this.status.message;
      if (this.blockStatus) {
        this.email.reset();
      }
    });
  }
}
