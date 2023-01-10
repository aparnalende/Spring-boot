import { Alert, Snackbar, Table, TableHead, TableRow } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";
import DialogBox from "./DialogBox";
import Employee from "./Employee";

const EmployeeList = () => {
  const navigate = useNavigate();

  const [loading, setLoading] = useState(true);
  const [employees, setEmployees] = useState(null);
  const [deleteId, setDeletedId] = useState();
  const [open, setOpen] = useState(false);
  const [snackbarFlag, setSnackbarFlag] = React.useState(false);
  const [snackbarErrorFlag, setSnackbarErrorFlag] = React.useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await EmployeeService.getEmployees();
        setEmployees(response.data);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  const deleteEmployee = (e, id) => {
    e.preventDefault();
    setDeletedId(id);
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };
  const handleConfirm = () => {
    EmployeeService.deleteEmployee(deleteId)
      .then((res) => {
        if (employees) {
          setEmployees((prevElement) => {
            return prevElement.filter((employee) => employee.id !== deleteId);
          });
        }
        setSnackbarFlag(true);
      })
      .catch((error) => {
        console.log(error);
        setSnackbarFlag(false);
      });
    setOpen(false);
  };
  const handleCancle = () => {
    setOpen(false);
  };
  const onCloseSnackbar = () => {
    setSnackbarFlag(false);
    setSnackbarErrorFlag(false);
  };
  return (
    <div className="container mx-auto my-8">
      <DialogBox
        open={open}
        handleClose={handleClose}
        handleConfirm={handleConfirm}
        handleCancle={handleCancle}
      />
      <Snackbar
        open={snackbarFlag}
        autoHideDuration={2000}
        anchorOrigin={{ vertical: "bottom", horizontal: "right" }}
        style={{ width: "30%" }}
        onClose={onCloseSnackbar}
      >
        <Alert
          onClose={onCloseSnackbar}
          variant="success"
          sx={{ width: "100%" }}
        >
          Record deleted successfully!!
        </Alert>
      </Snackbar>
      <Snackbar
        open={snackbarErrorFlag}
        autoHideDuration={2000}
        anchorOrigin={{ vertical: "bottom", horizontal: "right" }}
        style={{ width: "30%" }}
        onClose={onCloseSnackbar}
      >
        <Alert onClose={onCloseSnackbar} variant="Error" sx={{ width: "100%" }}>
          Something went wrong !! Please try after sometime.
        </Alert>
      </Snackbar>
      <div className="h-12">
        <button
          onClick={() => navigate("/addEmployee")}
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold"
        >
          Add Employee
        </button>
      </div>
      <div className="flex shadow border-b mx-[90px]">
        {/* <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                ID
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                First Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Last Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Email ID
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {employees.map((employee, index) => (
                <Employee
                  index={index}
                  employee={employee}
                  deleteEmployee={deleteEmployee}
                  key={employee.id}
                ></Employee>
              ))}
            </tbody>
          )}
        </table> */}
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                ID
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                First Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Last Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Email ID
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {employees ? (
                employees.map((employee, index) => (
                  <Employee
                    index={index}
                    employee={employee}
                    deleteEmployee={deleteEmployee}
                    key={employee.id}
                  ></Employee>
                ))
              ) : (
                <h4>Data not available</h4>
              )}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
};

export default EmployeeList;
