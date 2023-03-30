import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import { Grid } from "@mui/material";
import AppRoutes from "./routes";

function App() {
  const [count, setCount] = useState(0);

  return (
    <Grid
      sx={{
        height: "100vh",
        width: "100vw",
        backgroundColor: "blue",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <Grid sx={{ width: "90%", height: "90%", backgroundColor: "white" }}>
        <AppRoutes />
      </Grid>
    </Grid>
  );
}

export default App;
