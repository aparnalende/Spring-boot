import { Delete, Edit } from "@mui/icons-material";
import { Tooltip, Typography } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";

const Employee = ({ index, employee, deleteEmployee }) => {
  const navigate = useNavigate();
  const editEmployee = (e, id) => {
    e.preventDefault();
    navigate(`/editEmployee/${id}`);
  };

  return (
    <tr key={employee.id}>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{index + 1}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{employee.firstName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{employee.lastName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{employee.emailId}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
        <a
          onClick={(e, id) => editEmployee(e, employee.id)}
          className="text-indigo-600 hover:text-indigo-800 px-4 hover:cursor-pointer"
        >
          <Tooltip title={<Typography>Edit</Typography>}>
            <Edit />
          </Tooltip>
        </a>
        <a
          onClick={(e, id) => deleteEmployee(e, employee.id)}
          className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer"
        >
          <Tooltip title={<Typography>Delete</Typography>}>
            <Delete style={{ color: "red" }} />
          </Tooltip>
        </a>
      </td>
    </tr>
  );
};

export default Employee;
