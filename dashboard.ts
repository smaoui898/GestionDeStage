import { Component, AfterViewInit } from '@angular/core';
import { Chart, registerables } from 'chart.js';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { 
  faUsersCog, 
  faThLarge, 
  faUserGraduate,
  faUserTie,
  faTasks,
  faStar,
  faFileAlt,
  faCog,
  faUser,
  faArrowUp,
  faUserCheck,
  faCalendarAlt,
  faClock
} from '@fortawesome/free-solid-svg-icons';

interface Encadrant {
  nom: string;
  service: string;
  stagiaires: number;
  note: number;
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css'],
  imports: [FontAwesomeModule]
})
export class Dashboard implements AfterViewInit {
  // Font Awesome icons
  faUsersCog = faUsersCog;
  faThLarge = faThLarge;
  faUserGraduate = faUserGraduate;
  faUserTie = faUserTie;
  faTasks = faTasks;
  faStar = faStar;
  faFileAlt = faFileAlt;
  faCog = faCog;
  faUser = faUser;
  faArrowUp = faArrowUp;
  faUserCheck = faUserCheck;
  faCalendarAlt = faCalendarAlt;
  faClock = faClock;

  // Data properties
  adminEmail = 'admin@entreprise.fr';
  totalStagiaires = 42;
  stagiairesActifs = 28;
  dureeMoyenne = 3.5;
  noteMoyenne = 7.8;
  topEncadrants: Encadrant[] = [
    { nom: 'Dupont M.', service: 'Développement', stagiaires: 6, note: 8.5 },
    { nom: 'Martin L.', service: 'Marketing', stagiaires: 4, note: 7.9 },
    { nom: 'Robert C.', service: 'Finance', stagiaires: 3, note: 7.2 }
  ];

  constructor() {
    Chart.register(...registerables);
  }

  ngAfterViewInit(): void {
    this.initCharts();
  }

  private initCharts(): void {
    this.createDurationChart();
    this.createRatingChart();
    this.createFiliereChart();
  }

  private createDurationChart(): void {
    const ctx = document.getElementById('durationChart') as HTMLCanvasElement;
    new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['1 mois', '2 mois', '3 mois', '4 mois', '6 mois'],
        datasets: [{
          label: 'Nombre de stagiaires',
          data: [5, 8, 14, 10, 5],
          backgroundColor: '#93c5fd',
          borderColor: '#2563eb',
          borderWidth: 1
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          y: {
            beginAtZero: true,
            max: 15
          }
        },
        plugins: {
          legend: {
            display: false
          }
        }
      }
    });
  }

  private createRatingChart(): void {
    const ctx = document.getElementById('ratingChart') as HTMLCanvasElement;
    new Chart(ctx, {
      type: 'line',
      data: {
        labels: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Juin'],
        datasets: [{
          label: 'Note moyenne',
          data: [7.2, 7.0, 7.5, 7.6, 7.8, 8.2],
          fill: false,
          borderColor: '#2563eb',
          tension: 0.3,
          pointBackgroundColor: '#ffffff',
          pointBorderColor: '#2563eb',
          pointBorderWidth: 2,
          pointRadius: 4
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
          y: {
            min: 6,
            max: 9,
            ticks: {
              stepSize: 0.5
            }
          }
        }
      }
    });
  }

  private createFiliereChart(): void {
    const ctx = document.getElementById('filiereChart') as HTMLCanvasElement;
    new Chart(ctx, {
      type: 'doughnut',
      data: {
        labels: ['Informatique', 'Marketing', 'Finance', 'RH', 'Autre'],
        datasets: [{
          data: [42, 21, 15, 12, 10],
          backgroundColor: [
            '#3b82f6',
            '#10b981',
            '#f59e0b',
            '#8b5cf6',
            '#a855f7'
          ],
          borderWidth: 0
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: {
            position: 'right'
          }
        },
        cutout: '65%'
      }
    });
  }

  trackByEncadrant(index: number, encadrant: Encadrant): string {
    return encadrant.nom;
  }
}