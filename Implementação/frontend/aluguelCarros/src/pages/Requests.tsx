import {
  AppBar,
  Button,
  Grid,
  IconButton,
  Toolbar,
  Typography,
} from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import BasicCard from "../components/Card";
import NavBar from "../components/NavBar";

const carsmock = [1, 2, 3, 45, 6];

const Requests = () => {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    const getRequests = async () => {
      axios.get();

      setRequests();
    };

    getRequests();
  }, []);

  return (
    <Grid>
      <NavBar pageName={"Pedidos de Aluguel"} />
      <Grid container spacing={5} sx={{ p: 5 }}>
        {carsmock.map((car) => (
          <Grid item>
            <BasicCard />
          </Grid>
        ))}
      </Grid>
    </Grid>
  );
};

export default Requests;
