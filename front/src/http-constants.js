import axios from 'axios';

export const baseURL =
  !process.env.TARGET_ENV || process.env.TARGET_ENV === 'development'
    ? 'http://localhost:8080/'
    : 'http://api.example.com';

export const HTTP = axios.create({
  baseURL: baseURL
});
