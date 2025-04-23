use marketf;
INSERT INTO `marketf`.`nit`
(`NitCod`, `NitCart`, `NitCupo`, `NitDisp`, `NitDoc`, `NitNom`, `NitPlazo`)
VALUES
('001', 10000, 5000, 2000, '123456789', 'Juan Pérez', 30),
('002', 20000, 15000, 12000, '987654321', 'María García', 45),
('003', 30000, 20000, 18000, '112233445', 'Carlos López', 60),
('004', 15000, 10000, 8000, '556677889', 'Ana Martínez', 30),
('005', 5000, 2500, 1000, '334455667', 'Pedro Gómez', 15),
('006', 12000, 8000, 6000, '778899001', 'Lucía Fernández', 20),
('007', 25000, 20000, 15000, '445566778', 'Ricardo Ramírez', 40),
('08', 8000, 5000, 4000, '223344556', 'Sofía Martínez', 25),
('009', 18000, 12000, 10000, '667788990', 'Roberto Torres', 35),
('010', 4000, 3000, 2000, '998877665', 'Carolina Díaz', 10);


INSERT INTO `marketf`.`articulos`
(`ArtCod`, `ArtCosto`, `ArtLab`, `ArtNom`, `ArtPreVt`, `ArtSaldo`)
VALUES
('001', 5.00, 'Farmacéutica XYZ', 'Paracetamol 500mg', 12.50, 100),
('002', 7.50, 'Laboratorios ABC', 'Ibuprofeno 400mg', 15.75, 75),
('003', 10.00, 'Farmacéutica DEF', 'Amoxicilina 500mg', 25.00, 50),
('004', 2.50, 'Laboratorios UVW', 'Vitamina C 1000mg', 8.00, 200),
('005', 8.00, 'Farmacéutica GHI', 'Omeprazol 20mg', 18.00, 60),
('006', 3.00, 'Laboratorios JKL', 'Antigripal 500mg', 10.00, 120),
('007', 6.50, 'Farmacéutica MNO', 'Clorfenamina 4mg', 14.00, 80),
('008', 15.00, 'Laboratorios PQR', 'Cetirizina 10mg', 30.00, 40),
('009', 12.00, 'Farmacéutica STU', 'Metformina 850mg', 20.00, 90),
('010', 4.00, 'Laboratorios VWX', 'Salbutamol Aerosol', 12.00, 70);
