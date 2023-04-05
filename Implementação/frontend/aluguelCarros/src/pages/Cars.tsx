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
import Modal from "../components/Modal";
import NavBar from "../components/NavBar";
import useModal from "../hooks/useModal";

export interface Vehicle {
  id: number;
  brand: string;
  model: string;
  year: number;
}

const Cars = () => {
  const [cars, setCars] = useState<Vehicle[]>([]);
  const [selectedCar, setSelectedCar] = useState<Vehicle>();

  const carModal = useModal();

  const handleRentCar = async () => {
    const date = new Date();
    date.setFullYear(date.getFullYear() + 1)
    try {
      const rent = await axios.post('http://localhost:8080/rents', {
        requester: 1,
        vehicleId: selectedCar?.id,
        expireAt: date,
        status: "pending"
      })

      alert('aluguel realizado com sucesso')
      carModal.close()
    } catch (err: any) {
      alert('erro ' + err.response.data)
    }

  };
  const getCars = async () => {
    const vehicles = (await axios.get<Vehicle[]>('http://localhost:8080/vehicles')).data;

    setCars(vehicles);
  };

  useEffect(() => {
    getCars();
  }, []);

  return (
    <Grid>
      <NavBar pageName={"Carros"} />
      <Grid container spacing={5} sx={{ p: 5 }}>
        <Modal
          open={carModal.isOpen}
          close={carModal.close}
          title={"Fazer pedido de aluguel"}
        >
          Tem certeza que deseja realizar um pedido para este carro?
          <Button onClick={carModal.close}>Cancelar</Button>
          <Button onClick={handleRentCar}>Confirmar</Button>
        </Modal>
        {cars.map((car: any) => (
          <Grid item>
            <BasicCard
              key={car.id}
              title={car.model}
              subtitle={`${car.year} | ${car.brand}`}
              action={() => { carModal.open(car); setSelectedCar(car) }}
              actionText={"Alugar"}
            />
          </Grid>
        ))}
      </Grid>
    </Grid>
  );
};

export default Cars;
