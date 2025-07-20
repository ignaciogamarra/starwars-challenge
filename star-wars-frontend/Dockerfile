FROM node:20-alpine
WORKDIR /app

COPY . .

RUN npm install

RUN npm run build

EXPOSE 6969

CMD ["npm", "run", "preview", "--", "--port", "6969", "--host"]