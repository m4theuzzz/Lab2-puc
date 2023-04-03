import {
  AppBar,
  Button,
  Grid,
  IconButton,
  Toolbar,
  Typography,
} from "@mui/material";
import React from "react";
import BasicCard from "../components/Card";
import NavBar from "../components/NavBar";

const carsmock = [1, 2, 3, 45, 6];

const Requests = () => {
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
