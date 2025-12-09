declare module '@apiverve/cardgenerator' {
  export interface cardgeneratorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface cardgeneratorResponse {
    status: string;
    error: string | null;
    data: CardGeneratorData;
    code?: number;
  }


  interface CardGeneratorData {
      brand: string;
      count: number;
      cards: Card[];
      owner: Owner;
  }
  
  interface Card {
      cvv:        number;
      issuer:     string;
      id:         string;
      number:     string;
      expiration: string;
      brand:      string;
      numberAlt:  NumberAlt;
  }
  
  interface NumberAlt {
      masked:   string;
      unmasked: string;
      last4:    string;
  }
  
  interface Owner {
      name:    string;
      address: Address;
  }
  
  interface Address {
      street:  string;
      city:    string;
      state:   string;
      zipCode: string;
  }

  export default class cardgeneratorWrapper {
    constructor(options: cardgeneratorOptions);

    execute(callback: (error: any, data: cardgeneratorResponse | null) => void): Promise<cardgeneratorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: cardgeneratorResponse | null) => void): Promise<cardgeneratorResponse>;
    execute(query?: Record<string, any>): Promise<cardgeneratorResponse>;
  }
}
