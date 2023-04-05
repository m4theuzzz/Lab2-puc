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
import useModal from "../hooks/useModal";
import Modal from "../components/Modal";


const Requests = () => {
  const [requests, setRequests] = useState([]);

  const rentModal = useModal();

  const handleDeleteRent = async () => {
    try {
      const res = await axios.delete('http://localhost:8080/rents/' + rentModal.elementClicked?.id)

      alert('Excluido com sucesso')
      getRequests()
    } catch {
      alert('Erro')

    }

  };
  const getRequests = async () => {
    const rents = (await axios.get('http://localhost:8080/rents')).data;

    console.log(rents)

    setRequests(rents);
  };

  useEffect(() => {

    getRequests();
  }, []);

  return (
    <Grid>
      <NavBar pageName={"Pedidos de Aluguel"} />
      <Grid container spacing={5} sx={{ p: 5 }}>
        <Modal
          open={rentModal.isOpen}
          close={rentModal.close}
          title={"Pedido de aluguel"}
        >
          Tem certeza que deseja apagar

          {rentModal.elementClicked?.id} ?
          <Button onClick={rentModal.close}>Cancelar</Button>
          <Button onClick={handleDeleteRent}>Confirmar</Button>
        </Modal>
        {requests.map((rent: any) => (
          <Grid item>
            <BasicCard
              title={rent.id}
              subtitle={"pentendeu"}
              action={() => rentModal.open(rent)}
              actionText={"Excluir"}
            />
          </Grid>
        ))}
      </Grid>
    </Grid>
  );
};

export default Requests;
