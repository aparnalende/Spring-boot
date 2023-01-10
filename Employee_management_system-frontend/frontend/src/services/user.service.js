import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/test/";

const getPublicContent = () => {
  return axios.get(API_URL + "all");
};

const getUserBoard = () => {
  console.log({ headers: authHeader() });
  return axios.get(API_URL + "user", { headers: authHeader() });
};

const getMederatorBoard = () => {
  console.log({ headers: authHeader() });
  return axios.get(API_URL + "moderator", { headers: authHeader() });
};

const getAdminBoard = () => {
  console.log({ headers: authHeader() });
  return axios.get(API_URL + "admin", { headers: authHeader() });
};

const userSerice = {
  getPublicContent,
  getUserBoard,
  getMederatorBoard,
  getAdminBoard,
};

export default userSerice;
