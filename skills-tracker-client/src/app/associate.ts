export class Associate {
  associateId: number;
  associateName: string;
  emailId: string;
  mobileNumber: string;
  skills: string[] = [];

  constructor(associateId: number, associateName: string, emailId: string, mobileNumber: string, skills: string[]) {
    this.associateId = associateId;
    this.associateName = associateName;
    this.emailId = emailId;
    this.mobileNumber = mobileNumber;
    this.skills = skills;
  }
}

