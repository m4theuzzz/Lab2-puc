import { Button, Grid, TextField } from "@mui/material";
import axios from "axios";
import React from "react";

const Login = () => {
  const handleSignIn = async () => {
    axios.post();
  };

  return (
    <Grid
      container
      sx={{
        display: "flex",
        justifyContent: "center",
        width: 300,
        margin: "auto",
      }}
      xs={12}
      spacing={3}
    >
      <Grid item xs={12}>
        <TextField label="Email" fullWidth />
      </Grid>
      <Grid item xs={12}>
        <TextField label="Senha" fullWidth />
      </Grid>
      <Grid item xs={12}>
        <Button onClick={handleSignIn} variant="contained" fullWidth>
          Entrar
        </Button>
      </Grid>
    </Grid>
  );
};

export default Login;
